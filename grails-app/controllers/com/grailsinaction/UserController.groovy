package com.grailsinaction

class UserController {
    static scaffold = true

    //The action for the “search” form page
    def search() {}

    //Argument name matches name of the text field in the form
    def results(String loginId) {
        // Queries the DB for all users with a loginId that’s like the search string
        def users = User.where {
            loginId =~ "%${loginId}%"
        }.list()
        return [ users: users,
                 term: params.loginId,
                 totalUsers: User.count() ]
    }

//    def fetchUsers(String loginIdPart, Date fromDate = null) {
//        def users = User.where {
//            loginId =~ "%${loginIdPart}%"
//            //This criterion is included only if the fromDate parameter has a value.
//            if (fromDate) {
//                dateCreated >= fromDate
//            }
//        }.list()
//    }
}
