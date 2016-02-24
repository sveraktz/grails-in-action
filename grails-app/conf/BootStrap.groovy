import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        if (Environment.current != Environment.DEVELOPMENT) {

            if (!Post.count()) {
                createSampleData()
            }
        }
        else if (Environment.current.name == "Staging") {

        }
    }

//    def destroy = {
//    }

    private createSampleData() {

    }
}
