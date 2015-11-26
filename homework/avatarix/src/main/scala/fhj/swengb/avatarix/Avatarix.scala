package fhj.swengb.avatarix

import java.net.URL
import java.util.ResourceBundle
import javafx.application.Application
import javafx.fxml.{FXML, FXMLLoader, Initializable}
import javafx.scene.image.{Image, ImageView}
import javafx.scene.layout.{GridPane, BorderPane}
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage


import fhj.swengb.{Students, Speakers}

import scala.util.control.NonFatal

object Avatarix {
  def main(args: Array[String]) {
    Application.launch(classOf[Avatarix], args: _*)
  }
}

class Avatarix extends javafx.application.Application {


  val Fxml = "/fhj/swengb/avatarix/Avatarix.fxml"
  val Fxml_detail = "/fhj/swengb/avatarix/Avatarix_Detail.fxml"

  val Css = "fhj/swengb/avatarix/Avatarix.css"

  val loader = new FXMLLoader(getClass.getResource(Fxml))

  override def start(stage: Stage): Unit =
    try {
      stage.setTitle("Avatarix")
      loader.load[Parent]() // side effect
      val scene = new Scene(loader.getRoot[Parent])
      stage.setScene(scene)
      stage.getScene.getStylesheets.add(Css)
      stage.show()
    } catch {
      case NonFatal(e) => e.printStackTrace()
    }

}


class AvatarixController extends Initializable {
  @FXML var grid_g1: GridPane = _
  @FXML var grid_g2: GridPane = _
  @FXML var grid_g3: GridPane = _

  override def initialize(location: URL, resources: ResourceBundle): Unit = {
/**
  * */
    var counter1 = 0;
    for (student <- Students.studentGroup1) {
      grid_g1.getChildren.toArray()(counter1).asInstanceOf[ImageView].setImage(new Image(student.gitHubUser.avatarUrl.toString))
      counter1 += 1
    }

    var counter2 = 0;
    for (student <- Students.studentGroup2) {
      grid_g2.getChildren.toArray()(counter2).asInstanceOf[ImageView].setImage(new Image(student.gitHubUser.avatarUrl.toString))
      counter2 += 1
    }

    var counter3 = 0;
    for (student <- Students.studentGroup3) {
      grid_g3.getChildren.toArray()(counter3).asInstanceOf[ImageView].setImage(new Image(student.gitHubUser.avatarUrl.toString))
      counter3 += 1
    }

  }

}