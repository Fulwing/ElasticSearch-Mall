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

1. **Clone the Repository:**
```bash
https://github.com/Fulwing/ElasticSearch-Mall.git
```
3. **Install ElasticSearch:** Follow the installation instructions [here](https://www.elastic.co/downloads/elasticsearch).
4. **Run the Project:** Start exploring ElasticSearch Mall and use it as a sandbox for your ElasticSearch learning journey.

Feel free to reach out to me for questions or discussions. Happy learning and researching with ElasticSearch Mall!

## Usage

## Using the Java Jsoup Crawler

This project includes a Java Jsoup crawler to simplify the process of obtaining real data from JD. Jsoup is a Java library for working with real-world HTML. To leverage the crawler, follow these steps:

1. **Explore the Crawler Code:**
   - Navigate to the [`CrawlerService`](path/to/CrawlerService.java) class in the source code.
   - Review the methods to understand how data is fetched and processed.

2. **Configure Crawler Settings:**
   - Adjust the crawler settings such as URL, timeout, or data extraction logic according to your requirements. These settings can be found in the crawler service implementation.

3. **Initiate Crawling:**
   - Call the `parseContent` method in the `ContentService` class with the desired keyword:
     ```java
     GET http://localhost:your_port/parse/{keyword}
     ```
     This will trigger the crawler to fetch real data from JD based on the specified keyword.

4. **Customize Data Processing:**
   - If needed, modify the data processing logic in the crawler service to suit your specific use case.

By utilizing the Java Jsoup crawler, you can seamlessly integrate real data from JD into your ElasticSearch index. Feel free to explore and customize the crawler to meet your project's requirements.

This API will save the keywords to the index, with each call fetching 30 products.

## Searching

To perform a search, you have two options:

1. **Search Bar on Index Page:**
   - Navigate to [http://localhost:your_port/](http://localhost:your_port/) on your browser.
   - Use the search bar available on the index page to enter your keywords.
   - The search results will be displayed directly on the web page.

2. **Search API:**
   - Alternatively, you can use the following API for programmatic search:
     ```java
     // Search for items with highlights
     GET http://localhost:your_port/search/{keyword}/{pageNo}/{pageSize}
     ```
   - Replace `{keyword}`, `{pageNo}`, and `{pageSize}` with your search parameters.
   - This API returns the search results with highlights.

Choose the method that best fits your needs—whether you prefer a user-friendly interface with the search bar on the index page or direct programmatic access using the API.

This API retrieves item information with highlights enabled, providing users with a rich search experience.

### Tips

- Ensure ElasticSearch is properly configured and running. Follow the official [ElasticSearch installation guide](https://www.elastic.co/guide/en/elasticsearch/reference/current/install-elasticsearch.html) for detailed instructions.

- Monitor the system using Kibana to gain valuable insights into the search performance. Set up Kibana by following the steps outlined in the [official documentation](https://www.elastic.co/guide/en/kibana/current/install.html).

- Feel free to customize and extend the project according to your specific requirements. Explore additional features or integrate other technologies to enhance functionality.

- We welcome contributions! If you encounter any issues, have feature requests, or want to contribute improvements, please submit bug reports, feature requests, or pull requests. Your feedback is highly appreciated.

- Enjoy using ElasticSearch Mall for powerful and efficient searches. If you have any questions or need assistance, don't hesitate to reach out to the community.

Happy searching with ElasticSearch Mall!
