package com.grailsinaction

class User {

    String loginId
    String password
    Date dateCreated

    static hasOne = [ profile : Profile ]
    static hasMany = [ posts : Post, tags : Tag, following : User ]

    static constraints = {
        loginId size: 3..20, unique: true, nullable: false, matches: '[0-9]{7}[A-Za-z]'
        password size: 6..8, blank: false, validator: {passwd, user -> passwd != user.loginId}

        //Controls ordering of associated fields without any validation constraints
        tags()
        posts()
        profile nullable: true
    }

    static mapping = {
        posts sort:'dateCreated'
    }

    String toString() { return "User of $loginId (dateCreated: $dateCreated)" }

    String getDisplayString() { return loginId }
}
