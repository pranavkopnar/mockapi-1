import axios from 'axios';

const basePath = "http://localhost:8080/api/1.0";

export default {

  saveMockAPI: (endPoint) => {
    return axios.post(basePath + `/saveEndpoint`, endPoint);
  }

}