package com.grailsinaction



import spock.lang.*

/**
 *
 */
class QueryIntegrationSpec extends Specification {

    void "Simple property comparison"() {
        when: "Users are selected by a simple password match"
        def users = User.where {
            password == "testing"
        }.list(sort: "loginId")
        then: "The users with that password are returned"
        users*.loginId == ["frankie"]
    }
    void "Multiple criteria"() {
        when: "A user is selected by loginId or password"
        //Combines conditions with logical operators.
        def users = User.where {
            loginId == "frankie" || password == "crikey"
        }.list(sort: "loginId")
                then: "The matching loginIds are returned"
        users*.loginId == ["dillon", "frankie", "sara"]
    }
    void "Query on association"() {
        when: "The 'following' collection is queried"
        //Queries on single- and multi-ended associations via standard “.” Syntax.
        def users = User.where {
            following.loginId == "sara"
        }.list(sort: "loginId")
        then: "A list of the followers of the given user is returned"
        users*.loginId == ["phil"]
    }
    void "Query against a range value"() {
        given: "The current date & time"
        def now = new Date()
        when: "The 'dateCreated' property is queried"
        def users = User.where {
            //Uses in operator plus a range to do a SQL BETWEEN query.
            dateCreated in (now - 1)..now
        }.list(sort: "loginId", order: "desc")

        then: "The users created within the specified date range are returned"
        users*.loginId == ["phil", "peter", "glen", "frankie",
                           "chuck_norris", "admin"]
    }
    void "Retrieve a single instance"() {
        when: "A specific user is queried with get()"
        def user = User.where {
            loginId == "phil"
            //Returns a single instance rather than list via get( ).
            //Throws an exception if there’s more than one matching result.
        }.get()

        then: "A single instance is returned"
        user.password == "thomas"
    }
}
