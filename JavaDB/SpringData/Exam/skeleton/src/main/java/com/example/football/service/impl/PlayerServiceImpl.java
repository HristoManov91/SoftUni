package com.example.football.service.impl;

import com.example.football.models.dto.PlayerSeedDto;
import com.example.football.models.dto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";

    private final PlayerRepository playerRepository;
    private final StatService statService;
    private final TownService townService;
    private final TeamService teamService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public PlayerServiceImpl(PlayerRepository playerRepository, StatService statService, TownService townService, TeamService teamService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.playerRepository = playerRepository;
        this.statService = statService;
        this.townService = townService;
        this.teamService = teamService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        PlayerSeedRootDto playerSeedRootDto = xmlParser.fromFile(PLAYERS_FILE_PATH, PlayerSeedRootDto.class);

        List<PlayerSeedDto> collectPlayerSeedDto = playerSeedRootDto.getPlayers().stream()
                .filter(playerSeedDto -> {
                    boolean isValid = validationUtil.isValid(playerSeedDto);
                    sb.append(isValid
                            ? String.format("Successfully imported Player %s %s - %s",
                            playerSeedDto.getFirstName(), playerSeedDto.getLastName(), playerSeedDto.getPosition().name())
                            : "Invalid Player")
                            .append(System.lineSeparator());

                    return isValid;
                }).collect(Collectors.toList());

        List<Player> collect = collectPlayerSeedDto.stream()
                .map(playerSeedDto -> {
                    Player player = modelMapper.map(playerSeedDto, Player.class);
                    player.setTown(townService.findTownByName(playerSeedDto.getTownName().getName()));
                    player.setTeam(teamService.findTeamByName(playerSeedDto.getTeamName().getName()));
                    player.setStat(statService.findById(playerSeedDto.getStatId().getId()));
                    return player;
                })
                .collect(Collectors.toList());

        collect
                .forEach(playerRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String exportBestPlayers() {
        StringBuilder sb = new StringBuilder();
        LocalDate lowerDate = LocalDate.parse("01-01-1995" , DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate upperDate = LocalDate.parse("01-01-2003" , DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        List<Player> players = playerRepository
                .findAllByBirthDateBetweenOrderByShootingDescThanByPassingDescThanByEnduranceDescThanByLastName(
                        lowerDate, upperDate);

        players.forEach(player -> {
            sb.append(String.format("Player - %s %s\n" +
                    "\tPosition - %s\n" +
                    "\tTeam - %s\n" +
                    "\tStadium - %s\n", player.getFirstName() , player.getLastName() , player.getPosition().name() ,
                    player.getTeam().getName() , player.getTeam().getStadiumName()))
                    .append(System.lineSeparator());
        });


        return sb.toString().trim();
    }
}
