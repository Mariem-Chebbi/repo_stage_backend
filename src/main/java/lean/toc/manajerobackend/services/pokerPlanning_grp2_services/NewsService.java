package lean.toc.manajerobackend.services.pokerPlanning_grp2_services;


import jakarta.persistence.EntityNotFoundException;
import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.News;
import lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories.NewsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {
    NewsRepository newsRepository ;
    public News addNews(News news) {
        return newsRepository.save(news);
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public News getNewsById(String id) {
        return newsRepository.findById(id).orElse(null);
    }

    public News updateNews (News news, String id) {
        News existingNews = newsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));
        existingNews.setTitle(news.getTitle());
        existingNews.setNewsDescription(news.getNewsDescription());
        return newsRepository.save(existingNews);
    }
    public void deleteNews(String id) {
        newsRepository.deleteById(id);
    }


}
