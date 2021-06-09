import React, { useEffect, useState } from "react";
import Select from "react-select";
import { ToastContainer, toast } from "react-toastify";
import BaseForm from "../../../../components/BaseForm";
import { Teacher, TeacherResponse } from "../../../../types/Teacher";
import { makeRequest } from "../../../../utils/request";

type FormState = {
  name: string;
  addressNumber: number;
  addressComplement: string;
  description: string;
  imgProfile: string;
  address: string;
};

const TeacherForm = () => {
  const [formData, setFormData] = useState<FormState>({
    name: "",
    description: "",
    addressNumber: 0,
    addressComplement: "",
    imgProfile: "",
    address: "",
  });
  const [teacherResponse, setTeacherResponse] = useState<TeacherResponse>();
  const [toaster, setToaster] = useState(false);

  const handleOnChange = (
    event: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement | any>
  ) => {
    const name = event.target.name;
    const value = event.target.value;

    setFormData((data) => ({ ...data, [name]: value }));
  };

  const handleChangeSelect = (selectedOptions: Teacher | null | void) => {
    const options = selectedOptions;
    const areaString = JSON.stringify(options);
    const courseIdJSON = JSON.parse(areaString);
    const courseId = courseIdJSON.id;
    setFormData((data) => ({ ...data, courseId }));
    console.log(formData);
  };

  useEffect(() => {
    const params = {
      page: 1,
      linesPerPage: 5,
    };
    makeRequest({ url: "/courses", params: params }).then((response) =>
      setTeacherResponse(response.data)
    );
  }, []);

  let idList = [];

  teacherResponse?.content.map((item) => {
    idList.push(item.id);
  });

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const payload = {
      ...formData,
    };

    console.log("PAYLOAD: ");
    console.log(payload);

    makeRequest({ url: "/teachers", method: "POST", data: payload })
      .then((response) => {
        setToaster(true);
        toast.success("Sucesso");
      })
      .catch(() => {
        setToaster(true);
        toast.error("Erro");
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <BaseForm title="Cadastrar Professor">
        <input
          type="text"
          className="form-control mt-3"
          name="name"
          value={formData.name}
          placeholder="Nome"
          onChange={handleOnChange}
        />
        <textarea
          name="description"
          value={formData.description}
          className="form-control mt-3"
          placeholder="Descrição"
          onChange={handleOnChange}
        ></textarea>

        <input
          type="text"
          className="form-control mt-3"
          name="imgProfile"
          value={formData.imgProfile}
          placeholder="URL da foto de perfil"
          onChange={handleOnChange}
        />

        <input
          type="text"
          className="form-control mt-3"
          name="address"
          value={formData.address}
          placeholder="Endereço"
          onChange={handleOnChange}
        />

        <input
          type="text"
          className="form-control mt-3"
          name="addressNumber"
          value={formData.addressNumber}
          placeholder="Número"
          onChange={handleOnChange}
        />

        <input
          type="text"
          className="form-control mt-3"
          name="addressComplement"
          value={formData.addressComplement}
          placeholder="Complemento"
          onChange={handleOnChange}
        />

        <Select
          options={teacherResponse?.content}
          className="mt-3"
          placeholder="Curso"
          onChange={handleChangeSelect}
          getOptionLabel={(option: Teacher) => option.name}
          getOptionValue={(option: Teacher) => String(option.id)}
        />

        {toaster === true ? <ToastContainer /> : null}
      </BaseForm>
    </form>
  );
};

export default TeacherForm;
