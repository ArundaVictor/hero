import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

	public static void main(String[] args) {

		ProcessBuilder process = new ProcessBuilder();
     Integer port;
     if (process.environment().get("PORT") != null) {
         port = Integer.parseInt(process.environment().get("PORT"));
     } else {
         port = 4567;
     }

     setPort(port);

     staticFileLocation("/public");
    String layout = "templates/layout.vtl";


     get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

      get("hero/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/hero-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

       get("/hero", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // model.put("tasks", Task.all());
      model.put("template", "templates/hero.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

      post("/hero", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String description = request.queryParams("description");
      Hero newHero = new Hero(description);
      request.session().attribute("hero", newHero);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



	}
}