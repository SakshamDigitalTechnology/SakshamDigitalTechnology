package technology.digital.saksham.model

import java.io.Serializable

class LoginModel : Serializable {
    var mobilenumber: String? = null
    var emailaddress: String? = null
    var password: String? = null
    var collegename: String? = null
    var branchname: String? = null
    var username: String? = null

    constructor(
        mobilenumber: String?,
        emailaddress: String?,
        password: String?,
        collegename: String?,
        branchname: String?,
        username: String?
    ) {
        this.mobilenumber = mobilenumber
        this.emailaddress = emailaddress
        this.password = password
        this.collegename = collegename
        this.branchname = branchname
        this.username = username
    }

    constructor()

}
