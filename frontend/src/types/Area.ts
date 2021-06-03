import { Course } from "./Course";

export type AreaResponse = {
  content: Area[];
  totalPages: number;
};

export type Area = {
  id: number;
  name: string;
  course: Course[];
};
