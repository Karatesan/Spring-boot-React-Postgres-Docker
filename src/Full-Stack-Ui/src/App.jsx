import React, { useEffect, useState } from "react";
import getAllStudents from "./client";
import { Table, Avatar, Spin } from "antd";

const App = () => {
  const [students, setStudents] = useState([]);
  useEffect(() => {
    getAllStudents().then((response) => {
      setTimeout(() => {
        setStudents(response.data);
      }, 2000);
    });
  }, []);

  const studentsData = students.map((student) => {
    return {
      key: student.id,
      firstName: student.firstName,
      lastName: student.lastName,
      email: student.email,
      gender: student.gender,
    };
  });
  const columns = [
    {
      title: "",
      key: "avatar",
      render: (text, student) => (
        <Avatar size="large">{`${student.firstName.charAt(0).toUpperCase()}
          ${student.lastName.charAt(0).toUpperCase()}`}</Avatar>
      ),
    },
    {
      title: "Student ID",
      dataIndex: "id",
      key: "id",
    },
    {
      title: "First name",
      dataIndex: "firstName",
      key: "firstName",
    },
    {
      title: "Last name",
      dataIndex: "lastName",
      key: "lastName",
    },
    {
      title: "Email",
      dataIndex: "email",
      key: "email",
    },
    {
      title: "Gender",
      dataIndex: "gender",
      key: "gender",
    },
  ];
  return (
    <div className="flex flex-col justify-center items-center">
      <div className="w-[1000px] h-min-[300px] flex justify-center items-center] border-2 border-solid relative">
        <div
          id="spinner-container"
          className="absolute top-[65px] left-[480px] z-top"
        >
          {!students.length && <Spin tip="Loading" size="large" />}
        </div>
        <div id="table-container" className="z-bot">
          <Table dataSource={students} columns={columns} rowKey="id" />
        </div>
      </div>
    </div>
  );
};

export default App;
