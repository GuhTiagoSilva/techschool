import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Pagination from "../../components/Pagination";
import { TeacherResponse } from "../../types/Teacher";
import { makeRequest } from "../../utils/request";
import TeacherCard from "./components/TeacherCard";
import "./styles.scss";

const TeacherCatalog = () => {
  const [teacherResponse, setTeacherResponse] = useState<TeacherResponse>();
  const [activePage, setActivePage] = useState(0);

  const params = {
    page: activePage,
    linesPerPage: 5,
  };

  useEffect(() => {
    makeRequest({ url: "/teachers", params: params })
      .then((response) => setTeacherResponse(response.data))
      .finally(() => {});
  }, [activePage]);

  return (
    <div className="catalog-container">
      <header className="catalog-header">
        <h1 className="catalog-title">Catálogo de Professores</h1>
        <button className="btn btn-primary create-course-button">
          Cadastrar Novo Professor
        </button>
      </header>

      <div className="catalog-teachers">
        {teacherResponse?.content.map((teacher) => (
          <Link to={`/products/${teacher.id}`} key={teacher.id}>
            <TeacherCard teacher={teacher} />
          </Link>
        ))}
        {}
      </div>

      {teacherResponse?.totalPages && (
        <Pagination
          totalPages={teacherResponse?.totalPages}
          activePage={activePage}
          onChange={(page) => setActivePage(page)}
        />
      )}
    </div>
  );
};

export default TeacherCatalog;
