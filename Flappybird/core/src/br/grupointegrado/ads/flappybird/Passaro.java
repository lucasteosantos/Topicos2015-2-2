package br.grupointegrado.ads.flappybird;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by lucas on 05/10/2015.
 */
public class Passaro {
    private final World mundo;
    private final OrthographicCamera camera;
    private final Texture[] texturas;
    private Body corpo;

    public Passaro(World mundo, OrthographicCamera camera, Texture[] texturas) {
        this.mundo = mundo;
        this.camera = camera;
        this.texturas = texturas;

        inticorpo();
    }

    private void inticorpo(){
        float x = (camera.viewportWidth / 2 ) / Util.PIXEL_METRO;
        float y = (camera.viewportHeight / 2) / Util.PIXEL_METRO;

        corpo = Util.criarcorpo(mundo, BodyDef.BodyType.DynamicBody, x , y);

        CircleShape shape = new CircleShape();
        shape.setRadius(18 / Util.PIXEL_METRO);
        Fixture forma = Util.criarforma(corpo, shape, "PASSARO");
        shape.dispose();
    }
}