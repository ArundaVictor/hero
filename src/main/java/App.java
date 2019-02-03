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

      get("heroes/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/hero-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

       get("/heroes", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("hero", Hero.all());
      model.put("template", "templates/heroes.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

      post("/heroes", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      
        String description = request.queryParams("description");
        String age = request.queryParams("age");
        String power = request.queryParams("power");
        String weakness = request.queryParams("weakness");
        Hero newHero = new Hero(description,age,power,weakness);
      
      // request.session().attribute("hero", newHero);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

       get("/heroes/:id", (request, response) -> {
  HashMap<String, Object> model = new HashMap<String, Object>();
  Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
  model.put("hero", hero);
  model.put("template", "templates/hero.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

       get("/squads/new", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("template", "templates/squad-form.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

       post("/squads", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  String name = request.queryParams("name");
  Squad newSquad = new Squad(name);
  model.put("template", "templates/squad-sucess.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

    get("/squads", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("squads", Squad.all());
  model.put("template", "templates/squads.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

     get("/squads/:id", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
  model.put("squad", squad);
  model.put("template", "templates/squad.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

      get("squads/:id/heroes/new", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
  model.put("squad", squad);
  model.put("template", "templates/squad-heroes-form.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());


      post("/heroes", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();

  Squad squad = Squad.find(Integer.parseInt(request.queryParams("squadId")));

 
        String description = request.queryParams("description");
        String age = request.queryParams("age");
        String power = request.queryParams("power");
        String weakness = request.queryParams("weakness");
        Hero newHero = new Hero(description,age,power,weakness);
      
  
  squad.addHero(newHero);

  model.put("squad", squad);
  model.put("template", "templates/squad-heroes-success.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());








	}
}