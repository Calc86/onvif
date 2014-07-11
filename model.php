<?php

class Response{
    private error;
    private profiles = array();
}

class Profile{
    private name;
    private width;
    private height;
    private quality;

    //URI
    private video;
    //URI
    private snap;
}

class URI{
    private uri;
    private ttl;
    private invalidAfterConnection;
    private invalidAfterReboot;
}