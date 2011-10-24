package gototoday

class StatusCodeFilters {

    def filters = {
        all(controller: '*', action: '*') {
            afterView = {
                log.info("httpStatusCode=${response.response.coyoteResponse.status}")
            }

        }

    }

}
