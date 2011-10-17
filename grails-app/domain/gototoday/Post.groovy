package gototoday

class Post {
    String title
    String[] tags

    static belongsTo = [conference:Conference]

    static constraints = {
        title(blank: false)
    }
}
