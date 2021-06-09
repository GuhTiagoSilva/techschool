import { useEffect, useState } from "react";
import { useParams } from "react-router";
import { Link } from "react-router-dom";
import { ReactComponent as ArrowIcon } from "../../../../../src/assets/images/arrow.svg";
import { Course } from "../../../../types/Course";
import { makeRequest } from "../../../../utils/request";
import "./styles.scss";

type ParamsType = {
  courseId: string;
};

const CourseDetails = () => {
  const { courseId } = useParams<ParamsType>();
  const [course, setCourse] = useState<Course>();
  //   const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    // setIsLoading(true);

    makeRequest({ url: `/courses/${courseId}` })
      .then((response) => setCourse(response.data))
      .finally(() => {
        // setIsLoading(false);
      });
  }, [courseId]);

  return (
    <div className="course-details-container mb-5">
      <div className="card-base border-radius-20 course-details">
        <Link to="/courses" className="course-details-goback">
          <ArrowIcon className="icon-goback" />
          <h1 className="text-goback">Voltar</h1>
        </Link>
        <div className="row">
          <div className="col-6 pr-5">
            <>
              <div className="course-details-card text-center">
                <img
                  src={course?.imgUrl}
                  alt={course?.name}
                  className="course-details-image"
                />
              </div>
              <h1 className="course-details-name">{course?.name}</h1>
            </>
          </div>
          <div className="col-6 course-details-card">
            <h1 className="course-description-title">Descrição do Produto</h1>(
            <>
              <p className="course-description-text">{course?.description}</p>
            </>
            )
          </div>
        </div>
      </div>
    </div>
  );
};

export default CourseDetails;
