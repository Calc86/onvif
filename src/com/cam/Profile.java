package com.cam;

/**
 * Created by calc on 11.07.14.
 *
 */
public class Profile {
    private String name;
    private int width;
    private int height;
    private float quality;

    public class URI {
        private String uri;
        private String ttl;
        private boolean invalidAfterConnection;
        private boolean invalidAfterReboot;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getTtl() {
            return ttl;
        }

        public void setTtl(String ttl) {
            this.ttl = ttl;
        }

        public boolean isInvalidAfterConnection() {
            return invalidAfterConnection;
        }

        public void setInvalidAfterConnection(boolean invalidAfterConnection) {
            this.invalidAfterConnection = invalidAfterConnection;
        }

        public boolean isInvalidAfterReboot() {
            return invalidAfterReboot;
        }

        public void setInvalidAfterReboot(boolean invalidAfterReboot) {
            this.invalidAfterReboot = invalidAfterReboot;
        }
    }

    private URI video;
    private URI snap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getQuality() {
        return quality;
    }

    public void setQuality(float quality) {
        this.quality = quality;
    }

    public URI getVideo() {
        return video;
    }

    public void setVideo(URI video) {
        this.video = video;
    }

    public URI getSnap() {
        return snap;
    }

    public void setSnap(URI snap) {
        this.snap = snap;
    }
}
