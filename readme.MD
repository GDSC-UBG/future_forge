# YES MOM

In an effort to support the well-being of women after giving birth, the "YesMom!" application is presented as an innovative solution to overcome the emotional challenges that young mothers often experience after giving birth. Baby blues is a common phenomenon that includes feelings of anxiety, sadness, and mood changes in mothers after giving birth. This application aims to provide the support, information and resources that mothers need to experience the postpartum period better.

## Stage - 2 [Usage]

Based on the sequence diagram in [stage-1](https://) the feature that we created shows that users will receive a daily remainder notification, then click on the notification to add daily notes. Following are the procedures for using the application based on sequence diagrams and a few additions to support the process.

- First, download and install the yesmom prototype application at the following [Link](https://)
- Do **Register** and **Login**.
- Create a schedule on the calendar page, suggestions for making a schedule for the near future so that you can get test notifications immediately, for example in the next 5 minutes.
- then finally add your daily notes.

## Api Spec

### - Register

- Path:
  `/register`
- Method:
  `POST`
- Request:
  - body request
    ```
    {
      "name": "admin",
      "email": "admin@gmail.com",
      "password": "string123",
      "role": "admin",
      "fcm_token": "xxxxxxxx"
    }
    ```
  - Response
    ```
    {
      "msg": "Successfully register",
      "data": {
          "name": "admin"
      }
    }
    ```

### - Login

- Path:
  `/login`
- Method:
  `POST`
- Request:
  - body request
    ```
    {
      "email": "admin@gmail.com",
      "password": "string123"
    }
    ```
  - Response
    ```
    {
        "msg": "Successfully login",
        "key": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MiwiaWF0IjoxNzA1MDY4NjE1LCJleHAiOjE3MDUyNDE0MTV9.Ecav7j1SdCHS3B14OJ9QM8aBlVnQX2V9eYuyIPLbPzs"
    }
    ```

### - Get All Notes

- Path:
  `/notes`
- Method:
  `GET`
- Request:
  - body request

  - Response
    ```
    {
      "msg": "succes retrive all notes",
      "data": [
          {
              "id_daily": 1,
              "id_user": 2,
              "text": null,
              "emotional_score": null,
              "createdAt": "2024-01-12T15:12:03.000Z",
              "updatedAt": "2024-01-12T15:12:03.000Z"
          }
      ]
    }
    ```

### - Get Detail Notes

- Path:
  `/notes/:id`
- Method:
  `GET`
- Request:
  - body request

  - Response
    ```
    {
      "msg": "succes retrive all notes",
      "data": [
          {
              "id_daily": 1,
              "id_user": 2,
              "text": null,
              "emotional_score": null,
              "createdAt": "2024-01-12T15:12:03.000Z",
              "updatedAt": "2024-01-12T15:12:03.000Z"
          }
      ]
    }
    ```

### - Create Notes

- Path:
  `/notes/`
- Method:
  `POST`
- Request:
  - body request
    ```
    {
       "text": "example2",
       "emotional_score": 5
    }
    ```
  - Response
    ```
    {
        "msg": "succes create notes",
    }
    ```

### - Delete Notes

- Path:
  `/notes/:id`
- Method:
  `DELETE`
- Request:
  - body request
    ```

    ```
  - Response
    ```
    {
        "msg": "succes delete notes",
    }
    ```

### - Update Notes

- Path:
  `/notes/:id`
- Method:
  `PUT`
- Request:
  - body request
    ```
    {
        "text": "example2",
        "emotional_score": 5
    }
    ```
  - Response
    ```
    {
        "msg": "succes updated notes",
    }
    ```

### - Add Calender

- Path:
  `/calender`
- Method:
  `POST`
- Request:
  - body request
    ```
    {
        "title": "Meeting",
        "text": "Discuss project updates.",
        "type": "once",
        "date": "2024-01-12 10:50:25"
    }
    ```
  - Response
    ```
    {
        "success": true,
        "message": "Schedule created successfully."
    }
    ```

### - Update Profil User

- Path:
  `/users/profile`
- Method:
  `PUT`
- Request:
  - body request
    ```
    {
        "google_id": "test",
        "picture": "test",
        "birthdate": "test",
        "child_count": 1,
        "job": "test"
    }
    ```
  - Response
    ```
    {
        msg: "succes completed profil user"
    }
    ```

### - Delete User

- Path:
  `/users/:id`
- Method:
  `DELETE`
- Request:
  - body request

    ```

    ```

  - Response
    ```
    {
        msg: "succes deleted  user"
    }
    ```

### - Get Detail User

- Path:
  `/users/:id`
- Method:
  `GET`
- Request:
  - body request
    ```

    ```
  - Response
    ```
    {
        "msg": "Success retrieve detail user",
        "data": {
            "id_user": 1,
            "name": "admin23",
            "email": "admin23@gmail.com",
            "password": "$2a$08$VO6F4S31OvrUnA4/XOd1TOq1lYhOTBhNrk6XvBqWTyxgfkheZgxOW",
            "google_id": null,
            "fcm_token": "d_oYNemQRmu-IkJoaY3ifG:APA91bHtsQE4YDeb3HzmyWY7fnut_p8sU31meZl1YZVszFz_35fFuXTmLYomd1d6LGvCTdOSVPd-ibeXsqqSc0IlOLElDvtm0KT78uD6JQon9tqhUKnKkl9wxVUPqILxNq5MgyeDtDQ1",
            "role": "admin",
            "picture": null,
            "birthdate": null,
            "child_count": null,
            "job": null,
            "createdAt": "2024-01-12T14:35:31.000Z",
            "updatedAt": "2024-01-12T14:35:31.000Z"
        }
    }
    ```

### - Get All User

- Path:
  `/users`
- Method:
  `GET`
- Request:
  - body request
    ```

    ```
  - Response
    ```
    {
        "msg": "Success retrieve detail user",
        "data": {
            "id_user": 1,
            "name": "admin23",
            "email": "admin23@gmail.com",
            "password": "$2a$08$VO6F4S31OvrUnA4/XOd1TOq1lYhOTBhNrk6XvBqWTyxgfkheZgxOW",
            "google_id": null,
            "fcm_token": "d_oYNemQRmu-IkJoaY3ifG:APA91bHtsQE4YDeb3HzmyWY7fnut_p8sU31meZl1YZVszFz_35fFuXTmLYomd1d6LGvCTdOSVPd-ibeXsqqSc0IlOLElDvtm0KT78uD6JQon9tqhUKnKkl9wxVUPqILxNq5MgyeDtDQ1",
            "role": "admin",
            "picture": null,
            "birthdate": null,
            "child_count": null,
            "job": null,
            "createdAt": "2024-01-12T14:35:31.000Z",
            "updatedAt": "2024-01-12T14:35:31.000Z"
        }
    }
    ```
