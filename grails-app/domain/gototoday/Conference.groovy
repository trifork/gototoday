package gototoday

class Conference {
    String name
    String urlTag

    static hasMany = [posts: Post]

    static constraints = {
        name(blank: false)
        urlTag(blank: false, matches: "[a-z\\-0-9]+")
    }
}
