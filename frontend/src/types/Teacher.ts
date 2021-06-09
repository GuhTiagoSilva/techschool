export type TeacherResponse = {
  content: Teacher[];
  totalPages: number;
};

export type Teacher = {
  id: number;
  name: string;
  address: string;
  addressNumber: number;
  addressComplement: string;
  imgProfile: string;
  description: string;
  courseId: number;
};
