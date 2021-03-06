package com.couchbase.lite;

import java.io.File;

public class LiteTestContext implements Context {

    private String subdir;

    public LiteTestContext(String subdir) {
        this.subdir = subdir;
    }

    public LiteTestContext() {
        this.subdir = "test";
    }

    @Override
    public File getFilesDir() {
        return new File(getRootDirectory(), subdir);
    }

    @Override
    public void setNetworkReachabilityManager(NetworkReachabilityManager networkReachabilityManager) {

    }

    @Override
    public NetworkReachabilityManager getNetworkReachabilityManager() {
        return new TestNetworkReachabilityManager();
    }

    public File getRootDirectory() {
        String rootDirectoryPath = System.getProperty("user.dir");
        File rootDirectory = new File(rootDirectoryPath);
        rootDirectory = new File(rootDirectory, "data/data/com.couchbase.cblite.test/files");

        return rootDirectory;
    }

    class TestNetworkReachabilityManager extends NetworkReachabilityManager {
        @Override
        public void startListening() {

        }

        @Override
        public void stopListening() {

        }
    }

}
