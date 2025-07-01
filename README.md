## HTTP Cats

RESTful API based on https://http.cat project.

You can find all endpoints importing `http_cats_api.postman_collection.json` to your Postman.

## How to run the project

- Open this project in your IDE.
- Select `prod profile`.
- Run `maven package`.
- Run `docker compose up -d` in the root folder.
- Navigate to `http://localhost:8090/http-cats`.