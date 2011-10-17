import grails.util.GrailsUtil
import gototoday.Conference
import gototoday.Post
import org.apache.commons.logging.LogFactory

class BootStrap {
    private static final logger = LogFactory.getLog("gototoday.BootStrap")

    def init = { servletContext ->
        def environment = GrailsUtil.environment
        switch (environment) {
            case "development":
                //todo consider something like http://grails-plugins.github.com/grails-database-migration/
                if (!Conference.count()) {
                    log.info("Bootstrapping conferences for environment=${environment}")
                    Conference aarhus = new gototoday.Conference(name: "GOTO Århus 2011", urlTag: "aarhus-2011")
                    aarhus.addToPosts(new Post(title: "test post 1", conference: aarhus))
                    save(aarhus)
                }
                break
            case "production":
                if (!Conference.count()) {
                    log.info("Bootstrapping conferences for environment=${environment}")
                }
                break
        }
    }
    def destroy = {
    }

    void save(GroovyObject object) {
        if (object.hasErrors()) {
            throw new RuntimeException(object.errors)
        }
        object.save()
    }
}
