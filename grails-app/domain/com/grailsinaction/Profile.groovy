package com.grailsinaction

class Profile {
    //Declares Profile is attached to a User object.
    User user
    //Models binary data in a byte[ ]
    byte[] photo
    String fullName
    String bio
    String homepage
    String email
    String timezone
    String country
    String jabberAddress
    static constraints = {
        fullName blank: false
        bio nullable: true, maxSize: 1000
        homepage url: true, nullable: true
        email email: true, blank: false
        //Photo can be up to 2 MB in file size.
        photo nullable: true, maxSize: 2 * 1024 * 1024
        country nullable: true
        timezone nullable: true
        jabberAddress email: true, nullable: true
    }

    String toString() { return "Profile of $fullName (id: $id)" }

    String getDisplayString() { return fullName }
}

