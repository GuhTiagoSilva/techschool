import { Course } from "../../../../types/Course";
import "./styles.scss";

type Props = {
  course: Course;
};

const CourseCard = ({ course }: Props) => {
  return (
    <div className="card-base border-radius-10 product-card">
      <img
        src={course.imgUrl}
        alt={course.name}
        className="product-card-image"
      />
      <div className="product-info">
        <h6 className="product-name">{course.name}</h6>
      </div>
    </div>
  );
};
export default CourseCard;
