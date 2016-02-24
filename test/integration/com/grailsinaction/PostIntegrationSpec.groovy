package com.grailsinaction



import spock.lang.*

/**
 *
 */
class PostIntegrationSpec extends Specification {

    def "Adding posts to user links post to user"() {
        given: "A brand new user"
        def user = new User(loginId: 'joe', password: 'secret')
        user.save(failOnError: true)
        when: "Several posts are added to the user"
        //Creates User to hold Posts
        //Persists Post by adding to a User
        user.addToPosts(new Post(content: "First post... W00t!"))
        user.addToPosts(new Post(content: "Second post..."))
        user.addToPosts(new Post(content: "Third post..."))
        then: "The user has a list of posts attached"
        3 == User.get(user.id).posts.size()
    }

    def "Ensure posts linked to a user can be retrieved"() {
        given: "A user with several posts"
        def user = new User(loginId: 'joe', password: 'secret')
        //Adds posts to User
        user.addToPosts(new Post(content: "First"))
        user.addToPosts(new Post(content: "Second"))
        user.addToPosts(new Post(content: "Third"))
        user.save(failOnError: true)
        when: "The user is retrieved by their id"
        //Loads User via ID
        def foundUser = User.get(user.id)
        def sortedPostContent = foundUser.posts.collect {
            //Iterates through User’s posts
            it.content
        }.sort()
        then: "The posts appear on the retrieved user"
        //Sorts posts alphabetically
        sortedPostContent == ['First', 'Second', 'Third']
    }

    def "Exercise tagging several posts with various tags"() {
        given: "A user with a set of tags"
        def user = new User(loginId: 'joe', password: 'secret')
        //Sets up tags, adds them to user
        def tagGroovy = new Tag(name: 'groovy')
        def tagGrails = new Tag(name: 'grails')
        user.addToTags(tagGroovy)
        user.addToTags(tagGrails)
        user.save(failOnError: true)
        when: "The user tags two fresh posts"
        def groovyPost = new Post(content: "A groovy post")
        user.addToPosts(groovyPost)
        groovyPost.addToTags(tagGroovy)
        //Adds post to user, tag to post
        def bothPost = new Post(content: "A groovy and grails post")
        user.addToPosts(bothPost)
        bothPost.addToTags(tagGroovy)
        bothPost.addToTags(tagGrails)
        //Adds multiple tags to post
        then:
        user.tags*.name.sort() == [ 'grails', 'groovy']
        1 == groovyPost.tags.size()
        2 == bothPost.tags.size()
    }
}