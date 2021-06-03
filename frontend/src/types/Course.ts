export type CourseResponse = {
  content: Course[];
  totalPages: number;
};
export type Course = {
  id: number;
  name: string;
  areaId: number;
  imgUrl: string;
  description: string;
};
