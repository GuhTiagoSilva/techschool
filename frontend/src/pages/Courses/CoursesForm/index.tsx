import React, { useEffect, useState } from "react";
import "./styles.scss";
import BaseForm from "../../../components/BaseForm";
import { Area } from "../../../types/Area";
import { makeRequest } from "../../../utils/request";
import Select from "react-select";
import { toast, ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.min.css";

type FormState = {
  name: string;
  description: string;
  imgUrl: string;
};

const getSelectValue = () => {
  let select = document.querySelector(".select-area");
  console.log("select" + select);
};

getSelectValue();

const CoursesForm = () => {
  const [areaResponse, setAreaResponse] = useState<Area[]>([]);
  const [toaster, setToaster] = useState(false);

  const [formData, setFormData] = useState<FormState>({
    name: "",
    description: "",
    imgUrl: "",
  });

  const handleOnChange = (
    event: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement | any>
  ) => {
    const name = event.target.name;
    const value = event.target.value;

    setFormData((data) => ({ ...data, [name]: value }));
  };

  const handleChangeSelect = (selectedOptions: Area | null | void) => {
    const options = selectedOptions;
    const areaString = JSON.stringify(options);
    const area = JSON.parse(areaString);

    setFormData((data) => ({ ...data, area }));
    console.log(formData);
  };

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const payload = {
      ...formData,
    };

    console.log(payload);

    makeRequest({ url: "/courses", method: "POST", data: payload })
      .then((response) => {
        setToaster(true);
        toast.success("Sucesso!");
      })
      .catch(() => {
        setToaster(true);
        toast.error("Erro!");
      });
  };

  useEffect(() => {
    const params = {
      page: 1,
      linesPerPage: 5,
    };
    makeRequest({ url: "/areas/findAll", params: params }).then((response) =>
      setAreaResponse(response.data)
    );
  }, []);

  let idList = [];

  areaResponse.map((item) => {
    return idList.push(item.id);
  });

  return (
    <form onSubmit={handleSubmit}>
      <BaseForm title="Cadastrar Curso">
        <input
          type="text"
          className="form-control mt-3"
          name="name"
          id="title"
          value={formData.name}
          placeholder="Título"
          onChange={handleOnChange}
        />
        <textarea
          name="description"
          id="description"
          value={formData.description}
          className="form-control mt-3"
          placeholder="Descrição"
          onChange={handleOnChange}
        ></textarea>

        <input
          type="text"
          className="form-control mt-3"
          name="imgUrl"
          id="url"
          value={formData.imgUrl}
          placeholder="URL da foto de perfil"
          onChange={handleOnChange}
        />

        <Select
          options={areaResponse}
          className="mt-3"
          placeholder="Área"
          onChange={handleChangeSelect}
          getOptionLabel={(option: Area) => option.name}
          getOptionValue={(option: Area) => String(option.id)}
        />

        {toaster === true ? <ToastContainer /> : null}
      </BaseForm>
    </form>
  );
};

export default CoursesForm;
