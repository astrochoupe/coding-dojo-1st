package org.lorrainejug;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Unit test for simple Player.
 */
public class PlayerTest {
    //TODO Write tests!!!

    @Test
    public void it_should_score_zero_points_on_first_frame() throws Exception {

        Player player = new Player();

        player.play(0, 0);
        int score = player.getScore();

        assertThat(score).isEqualTo(0);
    }

    @Test
    public void it_should_score_one_points_on_first_frame() throws Exception {

        Player player = new Player();
        player.play(1, 0);
        int score = player.getScore();

        assertThat(score).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void it_should_not_accept_negative_number() throws Exception {

        Player player = new Player();
        player.play(-1, 2);
        int score = player.getScore();

        assertThat(score).isEqualTo(3);
    }

    @Test
    public void it_should_score_three_points_on_first_frame() throws Exception {

        Player player = new Player();
        player.play(1, 2);
        int score = player.getScore();

        assertThat(score).isEqualTo(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void maximum_10_frames() throws Exception {

        Player player = new Player();
        for (int i = 0; i < 11; i++) {
            player.play(1, 2);
        }

        int score = player.getScore();

        assertThat(score).isEqualTo(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void it_should_not_allow_more_than_10_bowls() throws Exception {

        Player player = new Player();
        player.play(7, 9);
    }

    @Test
    public void it_should_score_1_and_2() throws Exception {

        Player player = new Player();
        player.play(1, 0);
        assertThat(player.getScore()).isEqualTo(1);
        player.play(2, 0);
        assertThat(player.getScore()).isEqualTo(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void it_should_not_accept_negative_number_on_second_attempt() throws Exception {
        Player player = new Player();
        player.play(1, -2);
    }

    @Test
    public void it_should_score_a_spare() throws Exception {
        Player player = new Player();
        player.play(5,5);
        player.play(1,0);
        assertThat(player.getScore()).isEqualTo(12);
    }
    @Test
    public void it_should_score_2_spares() throws Exception {
        Player player = new Player();
        player.play(5,5);
        assertThat(player.getScore()).isEqualTo(10);
        player.play(5,5);
        assertThat(player.getScore()).isEqualTo(25);
        player.play(1,0);
        assertThat(player.getScore()).isEqualTo(27);
    }

    @Test
    public void it_should_score_a_strike() throws Exception {
        Player player = new Player();
        player.play(10,0);
        player.play(1,1);
        assertThat(player.getScore()).isEqualTo(14);
    }


}
