package fhj.swengb

import java.net.URL

import spray.json._

/**
 * Created by lad on 13.11.15.
 */
object GitHub {

  case class User( login: String,
                    avatarUrl: URL,
                    userUrl: URL,
                    htmlUrl: URL,
                    followersUrl: URL,
                    followingUrl: URL)

  object GithubUserProtocol extends DefaultJsonProtocol {

    implicit object GithubUserJsonFormat extends RootJsonFormat[User] {
      def write(user: User) =
        JsArray(
          JsString(user.login),
          JsString(user.avatarUrl.toString),
          JsString(user.userUrl.toString),
          JsString(user.htmlUrl.toString),
          JsString(user.followersUrl.toString),
          JsString(user.followingUrl.toString)

        )


      def read(value: JsValue) = {
        value match {
          case JsObject(m) =>
            val JsString(login) = m("login")
            val JsString(a_url) = m("avatar_url")
            val JsString(u_url) = m("url")
            val JsString(html_url) = m("html_url")
            val JsString(followers_url) = m("followers_url")
            val JsString(following_url) = m("following_url")

            User(login,
              new URL(a_url),
              new URL(u_url),
              new URL(html_url),
              new URL(followers_url),
              new URL(following_url)
            )
          case x =>
            deserializationError("GitHubUser expected.")
        }
      }

    }

  }

}


//