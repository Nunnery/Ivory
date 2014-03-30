package net.nunnerycode.bukkit.libraries.ivory.query;

import org.bukkit.Bukkit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public final class CurseForgeQuery {

  private static final String API_QUERY = "/servermods/projects?search=";
  private static final String API_HOST = "https://api.curseforge.com";
  private static final String PROJECT_ID = "id";
  private static final String PROJECT_NAME = "name";
  private static final String PROJECT_SLUG = "slug";
  private static final String PROJECT_STAGE = "stage";

  public BukkitProject query(String name) {
    URL url;
    URLConnection conn;
    BufferedReader reader = null;
    try {
      url = new URL(API_HOST + API_QUERY + name.toLowerCase());
      conn = url.openConnection();
      reader =
          new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String response = reader.readLine();
      JSONArray array = (JSONArray) JSONValue.parse(response);
      for (int i = 0; i < array.size(); i++) {
        JSONObject jsonObject = (JSONObject) array.get(i);
        String projectName = (String) jsonObject.get(PROJECT_NAME);
        if (!projectName.equalsIgnoreCase(name)) {
          continue;
        }
        String slug = (String) jsonObject.get(PROJECT_SLUG);
        ProjectStage
            projectStage =
            ProjectStage.valueOf(((String) jsonObject.get(PROJECT_STAGE)).toUpperCase());
        long id = (Long) jsonObject.get(PROJECT_ID);
        return new BukkitProject(id, projectName, slug, projectStage);
      }
    } catch (IOException e) {
      Bukkit.getLogger().info("Could not query CurseForge when looking for: " + name);
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  public static enum ProjectStage {
    PLANNING, ALPHA, BETA, RELEASE, DELETED, MATURE, INACTIVE, ABANDONED
  }

  public static class BukkitProject {

    private long id;
    private String name;
    private String slug;
    private ProjectStage projectStage;

    public BukkitProject(long id, String name, String slug,
                         ProjectStage projectStage) {
      this.id = id;
      this.name = name;
      this.slug = slug;
      this.projectStage = projectStage;
    }

    public long getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public String getSlug() {
      return slug;
    }

    public ProjectStage getProjectStage() {
      return projectStage;
    }
  }

}
