package gototoday

class Post {
    String title
    static constraints = {
        title(blank: false)
    }
}
