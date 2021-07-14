package services;

import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService {

    @Override
    public Double getConvert(int usd) {
        double usdConvert = usd;
        double vnd = usdConvert * 23000;
        return vnd;
    }
}
