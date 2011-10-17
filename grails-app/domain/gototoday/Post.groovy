package gototoday

class Post {
    String title

    static belongsTo = [conference:Conference]

    static constraints = {
        title(blank: false)
    }
}
