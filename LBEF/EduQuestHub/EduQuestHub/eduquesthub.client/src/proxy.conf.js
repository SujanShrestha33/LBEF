const PROXY_CONFIG = [
  {
    context: [
      , "/api/Auth/register", "/api/Auth/login", "/api/Course", "/api/Course/courses", "/api/Course/course", "/api/Enrollment/enroll", "/api/Enrollment/mycourses", "/api/Course/course", "/api/Enrollment/unenroll", "/api/Course/feedback", "/api/Course/forums", "/api/Auth/users", "api/Course/course"
    ],
    target: "http://localhost:5000",
    secure: false
  },

]

module.exports = PROXY_CONFIG;

