package hubbub

import com.grailsinaction.User


class ApplicationUser {

    String applicationName
    String password
    String apiKey
    static constraints = {
        //Shares constraints between classes
//        importFrom User, include: ['password']
        applicationName blank: false, unique: true
        apiKey blank: false
    }
}
