import axios from "axios";

const API_URL = "http://localhost:8080/api/students";

function getAllStudents() {
  return axios.get(API_URL);
}

export default getAllStudents;
