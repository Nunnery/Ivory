package net.nunnerycode.bukkit.libraries.ivory.query;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * A class that is used for querying the CurseForge API for BukkitDev.
 */
public final class CurseForgeQuery {

    private static final String API_QUERY = "/servermods/projects?search=";
    private static final String API_HOST = "https://api.curseforge.com";
    private static final String PROJECT_ID = "id";
    private static final String PROJECT_NAME = "name";
    private static final String PROJECT_SLUG = "slug";
    private static final String PROJECT_STAGE = "stage";

    /**
     * Returns a {@link net.nunnerycode.bukkit.libraries.ivory.query.CurseForgeQuery.BukkitProject} with the given name
     * from BukkitDev.
     *
     * @param name name of the project
     * @return project if it exists, null if it doesn't
     */
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
            e.printStackTrace();
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

    /**
     * An enum representing the various stages a project may have on BukkitDev.
     */
    public static enum ProjectStage {
        PLANNING, ALPHA, BETA, RELEASE, DELETED, MATURE, INACTIVE, ABANDONED
    }

    /**
     * A simple class to hold data about a project on BukkitDev. </p> Creating a new BukkitProject will not create a new
     * project on BukkitDev.
     */
    public static class BukkitProject {

        private long id;
        private String name;
        private String slug;
        private ProjectStage projectStage;

        /**
         * Instantiates a new BukkitProject.
         *
         * @param id           id of the project
         * @param name         name of the project
         * @param slug         slug of the project
         * @param projectStage stage of the project
         */
        public BukkitProject(long id, String name, String slug,
                             ProjectStage projectStage) {
            this.id = id;
            this.name = name;
            this.slug = slug;
            this.projectStage = projectStage;
        }

        /**
         * Gets and returns the project's ID.
         *
         * @return id of the project
         */
        public long getId() {
            return id;
        }

        /**
         * Gets and returns the project's name.
         *
         * @return name of the project
         */
        public String getName() {
            return name;
        }

        /**
         * Gets and returns the project's slug.
         *
         * @return slug of the project
         */
        public String getSlug() {
            return slug;
        }

        /**
         * Gets and returns the project's {@link net.nunnerycode.bukkit.libraries.ivory.query.CurseForgeQuery.ProjectStage}.
         *
         * @return stage of the project
         */
        public ProjectStage getProjectStage() {
            return projectStage;
        }
    }

}
