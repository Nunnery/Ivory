package net.nunnerycode.bukkit.libraries.ivory.query;

import org.junit.Assert;
import org.junit.Test;

public class CurseForgeQueryTest {

    @Test
    public void testQuery() throws Exception {
        CurseForgeQuery query = new CurseForgeQuery();
        CurseForgeQuery.BukkitProject project = query.query("WorldEdit");
        Assert.assertFalse(project == null);
        Assert.assertEquals("WorldEdit", project.getName());

        project = query.query("Hooooooooplaaaaaaaa");
        Assert.assertNull(project);
    }

}
