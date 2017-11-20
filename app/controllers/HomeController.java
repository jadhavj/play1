package controllers;

import play.mvc.*;
import play.mvc.Http.*;
import play.libs.F.Promise;
import play.data.Form;
import play.data.FormFactory;
import java.util.*;
import models.*;
/**
 * Created by M1039838 on 11/17/2017.
 */
public class HomeController extends Controller {

    public Result index() {
        return ok("Hello world!");
    }

    public Result login(String username) {
        return ok("Hello " + username);
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result testJson() {
        System.out.println(request().body().asJson());
        return ok(request().body().asJson());
    }


    public Promise<Result> testPromise() {
        Promise<Double> promiseOfPIValue = computePIAsynchronously();
        Promise<Result> promiseOfResult = promiseOfPIValue.map(pi -> ok("PI value computed: " + pi));
        return promiseOfResult;
    }

    public Promise<Double> computePIAsynchronously() {
        return Promise.promise(() -> intensiveComputation());
    }

    public double intensiveComputation() {
        return 3.14;
    }

    public Result testForm() {
        Form<User> userForm =  Form.form(User.class);

        User user = userForm.bind(request().body().asJson()).get();
        //User user =  userForm.bindFromRequest().get(); // form data

        return ok("Hello " + user.getEmail());
    }
}
