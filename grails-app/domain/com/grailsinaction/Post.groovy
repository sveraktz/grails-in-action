package com.grailsinaction

class Post {
    String content
    Date dateCreated

    static constraints = {
        content blank: false
    }
    static belongsTo = [ user : User ]
    static hasMany = [tags : Tag]

    //Specifies sort order for Post
    static mapping = {
        sort dateCreated:"desc"
    }
}

