package com.example.manager_movie.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MovieDto implements Validator {

    private int id;
    @NotBlank(message = "yêu cầu nhâp mã bộ phim!!!")
//    @Pattern(regexp = "^CI-\\d{4}$", message = "Chưa đúng định dạng CI-xxxx")
    private String codeMovie;
    @NotBlank(message = "yêu cầu nhâp phim!!!")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Nhập đúng định dạng tên phim")
    private String nameMovie;
    private String dateScreening;
    @Min(value = 0, message = "số lượng vé lớn hơn 0")
    private int numberOfTickets;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MovieDto movieDto = (MovieDto) target;
        java.sql.Date dateNow = new java.sql.Date(System.currentTimeMillis());
        Date movieDay = null;

        try {
            if (movieDto.getDateScreening().equals("")) {
                errors.rejectValue("dateScreening", "", "please input");
            } else {
                movieDay = new SimpleDateFormat("yyyy-MM-dd").parse(movieDto.getDateScreening());
                if (movieDay.before(dateNow)) {
                    errors.rejectValue("dateScreening", "", "Movie day cant not before day now");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!movieDto.getCodeMovie().equals("")) {
            if (!java.util.regex.Pattern.matches("^CI-\\d{4}$", movieDto.codeMovie)) {
                errors.rejectValue("codeMovie", "", "yêu cầu nhập đúng định dạng CI-XXXX  ");
            }
        }
    }

    public MovieDto() {
    }

    public MovieDto(int id, @NotBlank(message = "yêu cầu nhâp mã bộ phim!!!") @Pattern(regexp = "^CI-\\d{4}$", message = "Chưa đúng định dạng CI-xxxx") String codeMovie, @NotBlank(message = "yêu cầu nhâp phim!!!") @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Nhập đúng định dạng tên phim") String nameMovie, @NotBlank(message = "ngày chiếu không được để trống") String dateScreening, @Min(value = 0, message = "số lượng vé lớn hơn 0") int numberOfTickets) {
        this.id = id;
        this.codeMovie = codeMovie;
        this.nameMovie = nameMovie;
        this.dateScreening = dateScreening;
        this.numberOfTickets = numberOfTickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeMovie() {
        return codeMovie;
    }

    public void setCodeMovie(String codeMovie) {
        this.codeMovie = codeMovie;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getDateScreening() {
        return dateScreening;
    }

    public void setDateScreening(String dateScreening) {
        this.dateScreening = dateScreening;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

}
