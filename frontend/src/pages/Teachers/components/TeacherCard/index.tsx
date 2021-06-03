import React from "react";
import { Teacher } from "../../../../types/Teacher";
import "./styles.scss";

type Props = {
  teacher: Teacher;
};

const TeacherCard = ({ teacher }: Props) => {
  return (
    <div className="card-base border-radius-10 product-card">
      <img
        src={teacher.imgProfile}
        alt={teacher.name}
        className="product-card-image"
      />
      <div className="product-info">
        <h6 className="product-name">{teacher.name}</h6>
      </div>
    </div>
  );
};

export default TeacherCard;
