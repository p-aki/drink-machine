package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.*;
import static play.data.Form.*;
import views.html.*;

public class HomeController extends Controller {
	
	public class SampleForm {
		public String message;
	}
	
	public Result index() {
		return ok(index.render("write.", new Form(SampleForm.class)));
	}
	
	public Result send() {
		Form<SampleForm> f = form(SampleForm.class).bindFromRequest();
		if(!f.hasErrors()){
			SampleForm data = f.get();
			String msg = "you typed : " + data.message;
			return ok(index.render(msg,f));
		} else {
			return (index.render("ERROR", form(SampleForm.class)));
		}
	}
}
