package weatherrest.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import weatherrest.exception.ResourceNotFoundException;
import weatherrest.repository.WeatherRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {


    @Mock
    private WeatherRepository weatherRepository;

    @Autowired
    @InjectMocks
    private WeatherRepository weatherRepository;


    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {
        weatherData1 = weatherData2 = null;
        weatherDataList = null;
    }

    @Test
    void addWeatherData() throws ResourceNotFoundException {
        when(weatherRepository.save(any())).thenReturn(weatherData1);
        weatherRepository.addProduct(weatherData1);
        verify(weatherRepository, times(1)).save(any());
    }

    @Test
    void getAllWeatherData() {
        weatherRepository.save(weatherData1);
        //stubbing mock to return specific data
        when(weatherRepository.findAll()).thenReturn(weatherDataList);
        List<WeatherData> weatherDataList1 = weatherDataService.getAllWeatherDatas();
        assertEquals(weatherDataList1, weatherDataList);
        verify(weatherRepository, times(1)).save(weatherData1);
        verify(weatherRepository, times(1)).findAll();
    }

    @Test
    void getWeatherDataById() {
        Mockito.when(weatherRepository.findById(1)).thenReturn(Optional.ofNullable(weatherData1));
        assertThat(weatherRepository.getWeatherDataByid(weatherData1.getId())).isEqualTo(weatherData1);
    }

    @Test
    void deleteWeatherDataById() {
        public void givenIdTODeleteThenShouldDeleteTheWeatherData () {
            when(weatherDataService.deleteWeatherDataById(weatherData1.getId())).thenReturn(weatherData1);
            assertThat(weatherDataService.f);
            verify(weatherDataRepository, times(1)).findAll();
        }
    }
}