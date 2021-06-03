import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { CourseResponse } from "../../types/Course";
import { makeRequest } from "../../utils/request";
import "./styles.scss";

import CourseCard from "./components/CourseCard";
import { Course } from "../../types/Course";
import Pagination from "../../components/Pagination";

const Catalog = () => {
  const [courseResponse, setCourseResponse] = useState<CourseResponse>();
  const [activePage, setActivePage] = useState(0);

  const params = {
    page: activePage,
    linesPerPage: 5,
  };

  useEffect(() => {
    makeRequest({ url: "/courses", params: params })
      .then((response) => setCourseResponse(response.data))
      .finally(() => {});
  }, [activePage]);

  return (
    <div className="catalog-container mb-5">
      <header className="catalog-header">
        <h1 className="catalog-title">Catálogo de Cursos</h1>
        <Link to="/create">
          <button className="btn btn-primary create-course-button">
            Cadastrar Curso
          </button>
        </Link>
      </header>

      <div className="catalog-courses">
        {courseResponse?.content.map((course) => (
          <Link to={`/courses/${course.id}`} key={course.id}>
            <CourseCard course={course} />
          </Link>
        ))}
        {}
      </div>

      {courseResponse?.totalPages && (
        <Pagination
          totalPages={courseResponse?.totalPages}
          activePage={activePage}
          onChange={(page) => setActivePage(page)}
        />
      )}
    </div>
  );
};

export default Catalog;
