package com.grailsinaction

class Tag {

    String name
    User user

    static constraints = {
        name blank: false
    }
    static hasMany = [ posts : Post ]
    //Affects the side objects that can be added from
    static belongsTo = [ User, Post ]
}
