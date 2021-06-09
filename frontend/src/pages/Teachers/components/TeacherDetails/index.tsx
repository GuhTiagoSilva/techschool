import { useEffect, useState } from "react";
import { useParams } from "react-router";
import { Teacher } from "../../../../types/Teacher";
import { makeRequest } from "../../../../utils/request";
import { ReactComponent as ArrowIcon } from "../../../../../src/assets/images/arrow.svg";
import { Link } from "react-router-dom";
import "./styles.scss";
type ParamsType = {
  teacherId: string;
};

const TeacherDetails = () => {
  const { teacherId } = useParams<ParamsType>();
  const [teacher, setTeacher] = useState<Teacher>();

  useEffect(() => {
    makeRequest({ url: `/teachers/${teacherId}` })
      .then((response) => setTeacher(response.data))
      .finally(() => {});
  }, [teacherId]);

  console.log(teacher);
  return (
    <div className="teacher-details-container mb-5">
      <div className="card-base border-radius-20 teacher-details">
        <Link to="/teachers" className="teacher-details-goback">
          <ArrowIcon className="icon-goback" />
          <h1 className="text-goback">Voltar</h1>
        </Link>
        <div className="row">
          <div className="col-6 pr-5">
            (
            <>
              <div className="teacher-details-card text-center">
                <img
                  src={teacher?.imgProfile}
                  alt={teacher?.name}
                  className="teacher-details-image"
                />
              </div>
              x'
              <h1 className="teacher-details-name">{teacher?.name}</h1>
              <ul></ul>
            </>
            )
          </div>
          <div className="col-6 mt-3">
            <h1 className="teacher-description-title">
              Endereço: {teacher?.address} <br />
            </h1>
            <h4 className="teacher-description mt-5">
              Descrição: <br /> {teacher?.description}
            </h4>
          </div>
        </div>
      </div>
    </div>
  );
};

export default TeacherDetails;
