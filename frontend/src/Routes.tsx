import { BrowserRouter, Route, Switch } from "react-router-dom";
import Navbar from "./components/Navbar";
import Catalog from "./pages/Catalog";
import CourseDetails from "./pages/Catalog/components/CourseDetails";
import CoursesForm from "./pages/Courses/CoursesForm";
import Home from "./pages/Home";
import Teacher from "./pages/Teachers";
import TeacherDetails from "./pages/Teachers/components/TeacherDetails";
import TeacherForm from "./pages/Teachers/components/TeacherForm";

const Routes = () => {
  return (
    <BrowserRouter>
      <Navbar />
      <Switch>
        <Route path="/" exact>
          <Home></Home>
        </Route>
      </Switch>
      <Switch>
        <Route path="/courses" exact>
          <Catalog />
        </Route>
      </Switch>
      <Switch>
        <Route path="/courses/:courseId" exact>
          <CourseDetails />
        </Route>
      </Switch>
      <Switch>
        <Route path="/create" exact>
          <CoursesForm />
        </Route>
      </Switch>
      <Switch>
        <Route path="/teachers" exact>
          <Teacher />
        </Route>
      </Switch>
      <Switch>
        <Route path="/create/teacher">
          <TeacherForm />
        </Route>
      </Switch>
      <Switch>
        <Route path="/teachers/:teacherId">
          <TeacherDetails />
        </Route>
      </Switch>
    </BrowserRouter>
  );
};

export default Routes;
