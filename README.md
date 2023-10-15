# ElasticSearch Mall

Welcome to ElasticSearch Mall, mimic a famous Chinese e-commerce website. This project uses ElasticSearch as the search engine, with a Spring Boot backend and Vue.js frontend. The search functionality is enhanced with highlighting, and the entire system is monitored using Kibana.

## Learning and Research

This project is an excellent resource for individuals eager to learn ElasticSearch, an advanced search engine. Whether you're a beginner or an experienced developer, ElasticSearch Mall provides a hands-on experience to explore the capabilities of ElasticSearch.

### How to Use for Learning

If you're new to ElasticSearch or want to deepen your understanding, feel free to use this project as a practical learning tool. Explore the codebase, understand how data is indexed and searched, and experiment with different queries.

### Latest ElasticSearch Version

This project is built using the latest version of ElasticSearch (8.10.3). As there might not be tutorials specifically for this patch, you can leverage this codebase to navigate and understand the intricacies of the newest features.

### Contribution to Learning

If you discover new insights or improvements during your exploration, consider contributing back to the project. Your findings and enhancements can be valuable for others who are on the learning journey.

### Get Started

1. **Clone the Repository:** `https://github.com/Fulwing/ElasticSearch-Mall.git`
2. **Install ElasticSearch:** Follow the installation instructions [here](https://www.elastic.co/downloads/elasticsearch).
3. **Run the Project:** Start exploring ElasticSearch Mall and use it as a sandbox for your ElasticSearch learning journey.

Feel free to reach out to the community for questions or discussions. Happy learning and researching with ElasticSearch Mall!
## Usage

### Crawling Data

To populate your ElasticSearch index with real data from JD (Jingdong), use the following API:

```java
// Save keywords to the index
GET http://localhost:your_port/parse/{keyword}
```

This API will save the keywords to the index, with each call fetching 30 products.

### Searching

To perform a search, use the following API:

```java
// Search for items with highlights
GET http://localhost:your_port/search/{keyword}/{pageNo}/{pageSize}
```

This API retrieves item information with highlights enabled, providing users with a rich search experience.

### Tips

- Ensure ElasticSearch is properly configured and running. Follow the official [ElasticSearch installation guide](https://www.elastic.co/guide/en/elasticsearch/reference/current/install-elasticsearch.html) for detailed instructions.

- Monitor the system using Kibana to gain valuable insights into the search performance. Set up Kibana by following the steps outlined in the [official documentation](https://www.elastic.co/guide/en/kibana/current/install.html).

- Feel free to customize and extend the project according to your specific requirements. Explore additional features or integrate other technologies to enhance functionality.

- We welcome contributions! If you encounter any issues, have feature requests, or want to contribute improvements, please submit bug reports, feature requests, or pull requests. Your feedback is highly appreciated.

- Enjoy using ElasticSearch Mall for powerful and efficient searches. If you have any questions or need assistance, don't hesitate to reach out to the community.

Happy searching with ElasticSearch Mall!
